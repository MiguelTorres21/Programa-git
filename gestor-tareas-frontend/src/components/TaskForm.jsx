import { useState } from "react";
import { crearTarea } from "../services/tareasApi";

/**
 * Formulario para crear tareas
 */
function TaskForm({ onCreated }) {
    const [titulo, setTitulo] = useState("");

    const submit = async (e) => {
        e.preventDefault();
        await crearTarea({ titulo });
        setTitulo("");
        onCreated();
    };

    return (
        <form onSubmit={submit}>
            <input
                value={titulo}
                onChange={(e) => setTitulo(e.target.value)}
                placeholder="Nueva tarea"
                required
            />
            <button>Agregar</button>
        </form>
    );
}

export default TaskForm;
