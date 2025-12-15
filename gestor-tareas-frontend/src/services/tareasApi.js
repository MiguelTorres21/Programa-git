const API_URL = "http://localhost:8080/api/tareas";

/**
 * Obtiene todas las tareas desde la API
 */
export async function obtenerTareas() {
    const res = await fetch(API_URL);
    return res.json();
}

/**
 * Crea una nueva tarea
 */
export async function crearTarea(tarea) {
    const res = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(tarea),
    });
    return res.json();
}

/**
 * Elimina una tarea por ID
 */
export async function eliminarTarea(id) {
    await fetch(`${API_URL}/${id}`, {
        method: "DELETE",
    });
}
