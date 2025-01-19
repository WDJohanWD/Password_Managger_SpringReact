import React, { useState, useEffect } from 'react';
import { getPasswords, savePassword } from './PasswordService';

function App() {
    const [passwords, setPasswords] = useState([]);
    const [newPassword, setNewPassword] = useState({ service: '', username: '', encryptedPassword: '' });

    useEffect(() => {
        loadPasswords();
    }, []);

    const loadPasswords = async () => {
      const data = await getPasswords();
      if (Array.isArray(data)) {
          setPasswords(data);
      } else {
          console.error('Received data is not an array:', data);
          setPasswords([]); // Asegúrate de que sea un arreglo vacío si no es un arreglo
      }
  };
  

    const handleSubmit = async (e) => {
        e.preventDefault();
        await savePassword(newPassword);
        loadPasswords();
        setNewPassword({ service: '', username: '', encryptedPassword: '' });
    };

    return (
        <div>
            <h1>Password Manager</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Service"
                    value={newPassword.service}
                    onChange={(e) => setNewPassword({ ...newPassword, service: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Username"
                    value={newPassword.username}
                    onChange={(e) => setNewPassword({ ...newPassword, username: e.target.value })}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={newPassword.encryptedPassword}
                    onChange={(e) => setNewPassword({ ...newPassword, encryptedPassword: e.target.value })}
                />
                <button type="submit">Save</button>
            </form>

            <h2>Saved Passwords</h2>
            <ul>
                {passwords.map((password) => (
                    <li key={password.id}>
                        {password.service} - {password.username}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
