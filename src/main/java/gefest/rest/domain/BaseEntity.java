package gefest.rest.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity implements IEntity {

        @CreationTimestamp
        @Column(name= "created", nullable = false, updatable = false)
        private LocalDateTime created;

        @UpdateTimestamp
        private LocalDateTime modified;

        private Long ownerId;

        @Override
        public Long getId() {
                return null;
        }
}
