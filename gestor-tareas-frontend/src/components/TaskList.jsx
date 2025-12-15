import TaskItem from "./TaskItem";

/**
 * Lista de tareas
 */
function TaskList({ tareas, onChange }) {
    return (
        <ul>
            {tareas.map((t) => (
                <TaskItem key={t.id} tarea={t} onChange={onChange} />
            ))}
        </ul>
    );
}

export default TaskList;
