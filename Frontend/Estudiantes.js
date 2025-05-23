function guardarEst() {
    const tipoId = document.getElementById("tipoid").value;
    const numeroId = document.getElementById("numeroid").value;

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        tipoId: tipoId,
        numeroId: numeroId
    });

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("URL_DEL_BACKEND_PARA_GUARDAR", requestOptions)  // ← aquí irá la URL real
        .then(response => response.text())
        .then(result => console.log("Estudiante guardado:", result))
        .catch(error => console.error("Error al guardar estudiante:", error));
}

// Función para modificar estudiante
function modificarEst() {
    const nuevoNumeroId = document.getElementById("numeroid1").value;
    const nuevoTipoId = document.getElementById("nuevotipoid").value;
    const nuevoNombre = document.getElementById("nuevoNombre").value;

    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        numeroId: nuevoNumeroId,
        tipoId: nuevoTipoId,
        nombre: nuevoNombre
    });

    const requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("URL_DEL_BACKEND_PARA_MODIFICAR", requestOptions)  // ← aquí irá la URL real
        .then(response => response.text())
        .then(result => console.log("Estudiante modificado:", result))
        .catch(error => console.error("Error al modificar estudiante:", error));
}

