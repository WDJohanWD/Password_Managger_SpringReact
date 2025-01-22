import axios from 'axios';

const API_URL = 'http://localhost:9000/api/passwords';

export const getPasswords = async () => {
    try {
        const response = await axios.get(API_URL);
        console.log('Response data:', response.data); // Agrega este log
        return Array.isArray(response.data) ? response.data : []; // Asegúrate de que sea un arreglo
    } catch (error) {
        console.error('Error fetching passwords:', error);
        return []; // Devuelve un arreglo vacío si hay un error
    }
};

export const savePassword = async (password) => {
    const response = await axios.post(API_URL, password);
    return response.data;
};
