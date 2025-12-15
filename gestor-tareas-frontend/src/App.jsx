import { useEffect, useState } from "react";
import TaskForm from "./components/TaskForm";
import TaskList from "./components/TaskList";
import { obtenerTareas } from "./services/tareasApi";

/**
 * Componente principal de la aplicación
 */
function App() {
    const [tareas, setTareas] = useState([]);

    useEffect(() => {
        cargarTareas();
    }, []);

    const cargarTareas = async () => {
        const data = await obtenerTareas();
        setTareas(data);
    };

    return (
        <div style={{ padding: "20px" }}>
            <h1>Gestor de Tareas</h1>

            <TaskForm onCreated={cargarTareas} />
            <TaskList tareas={tareas} onChange={cargarTareas} />
        </div>
    );
}

export default App;
