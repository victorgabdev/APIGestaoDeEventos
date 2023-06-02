package com.victorgabriel.eventos.modules.organizers.entities;

import com.victorgabriel.eventos.shared.entities.BaseEntityUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity(name = "organizers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizer extends BaseEntityUser {
    private String adress;
    private String responsible;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
