// firebase.js

// Importar los módulos necesarios desde la CDN de Firebase
import { initializeApp } from "https://www.gstatic.com/firebasejs/11.8.1/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/11.8.1/firebase-analytics.js";

// Configuración de tu app de Firebase
const firebaseConfig = {
  apiKey: "AIzaSyD93QUxoYbCho0HgTgblpDqC5CSSBwZc20",
  authDomain: "asistencia-app-1b27c.firebaseapp.com",
  projectId: "asistencia-app-1b27c",
  storageBucket: "asistencia-app-1b27c.firebasestorage.app",
  messagingSenderId: "530253707021",
  appId: "1:530253707021:web:4217b2744923e1d83c6244",
  measurementId: "G-H7R61JMYHF"
};

// Inicializar Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
