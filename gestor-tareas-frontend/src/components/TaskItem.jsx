import { eliminarTarea } from "../services/tareasApi";

/**
 * Tarea individual
 */
function TaskItem({ tarea, onChange }) {
    const eliminar = async () => {
        await eliminarTarea(tarea.id);
        onChange();
    };

    return (
        <li>
            {tarea.titulo}
            <button onClick={eliminar}>Eliminar</button>
        </li>
    );
}

export default TaskItem;
