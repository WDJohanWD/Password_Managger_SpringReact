import axios from 'axios';

export const login = async (username, password) => {
    try {
        // Realiza la solicitud POST al backend con los datos correctos
        const response = await axios.post("http://localhost:9000/api/auth/login", {
            username: username,
            encryptedPassword: password // Asegúrate de usar el nombre correcto según tu backend
        });
        
        return response.data; // Si el login es exitoso, retornamos el mensaje del backend
    } catch (err) {
        // Si el error es causado por una respuesta del servidor, lo manejamos aquí
        if (err.response) {
            // Si el error viene del servidor, mostramos el mensaje del backend
            throw err.response.data;
        } else {
            // Si el error no viene del servidor, es un error de red u otro tipo
            throw new Error('An unexpected error occurred');
        }
    }
};
