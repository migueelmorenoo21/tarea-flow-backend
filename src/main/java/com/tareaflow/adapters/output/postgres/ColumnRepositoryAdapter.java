package com.tareaflow.adapters.output.postgres;

import com.tareaflow.adapters.output.postgres.entity.ColumnEntity;
import com.tareaflow.domain.model.Column;
import com.tareaflow.domain.port.out.ColumnRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ColumnRepositoryAdapter implements ColumnRepository {
    private final SpringDataColumnRepository jpa;

    public ColumnRepositoryAdapter(SpringDataColumnRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Column save(Column column) {
        ColumnEntity entity = new ColumnEntity(column);
        return jpa.save(entity).toDomain();
    }

    @Override
    public List<Column> findByBoardId(UUID boardId) {
        return jpa.findByBoardIdOrderByPositionAsc(boardId)
                .stream()
                .map(ColumnEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Column> findById(UUID columnId) {
        return jpa.findById(columnId)
                .map(ColumnEntity::toDomain);
    }
}
