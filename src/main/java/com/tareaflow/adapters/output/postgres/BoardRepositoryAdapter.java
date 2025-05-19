package com.tareaflow.adapters.output.postgres;

import com.tareaflow.domain.model.Board;
import com.tareaflow.domain.port.out.BoardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class BoardRepositoryAdapter implements BoardRepository {

    private final JdbcTemplate jdbc;

    public BoardRepositoryAdapter(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Board> findAllByUserId(UUID userId) {
        String sql = """
            SELECT DISTINCT b.*
            FROM boards b
            LEFT JOIN board_members bm ON bm.board_id = b.id
            WHERE b.owner_id = ? OR bm.user_id = ?
        """;

        return jdbc.query(sql, new Object[]{userId, userId}, (rs, rowNum) -> mapBoard(rs));
    }

    @Override
    public Board save(Board board) {
        String sql = """
            INSERT INTO boards (id, title, description, owner_id, created_at)
            VALUES (?, ?, ?, ?, ?)
        """;

        jdbc.update(sql,
                board.getId(),
                board.getTitle(),
                board.getDescription(),
                board.getOwnerId(),
                board.getCreatedAt()
        );

        return board;
    }

    private Board mapBoard(ResultSet rs) throws SQLException {
        return new Board(
                UUID.fromString(rs.getString("id")),
                rs.getString("title"),
                rs.getString("description"),
                rs.getObject("owner_id", UUID.class),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
