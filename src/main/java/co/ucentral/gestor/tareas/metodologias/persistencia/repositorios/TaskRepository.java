package co.ucentral.gestor.tareas.metodologias.persistencia.repositorios;

import co.ucentral.gestor.tareas.metodologias.persistencia.entidades.Task;
import co.ucentral.gestor.tareas.metodologias.persistencia.entidades.Project;
import co.ucentral.gestor.tareas.metodologias.persistencia.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedUsersContainingAndClosedFalse(User user);
    int countByProject(Project project);
    int countByProjectAndClosed(Project project, boolean closed);
    List<Task> findByProjectId(Long project);
    List<Task> findByClosed(boolean closed);
    @Query("SELECT t FROM Task t WHERE t.project.creator.username = :username AND t.closed = false")
    List<Task> findPendingTasksByUsername(String username);
}
