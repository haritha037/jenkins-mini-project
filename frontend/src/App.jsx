import { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState("Loading...");

  useEffect(() => {
    fetch(import.meta.env.VITE_BACKEND_URL + "/api/v1/hello")
      .then((res) => res.json())
      .then((data) => setMessage(data.message))
      .catch(() => setMessage("Failed to fetch from backend"));
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h1>Frontend App</h1>
      <p>
        <strong>Backend says:</strong> {message}
      </p>
    </div>
  );
}

export default App;
