import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './chocolate-style.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import { ChakraProvider, extendTheme } from "@chakra-ui/react";

const theme = extendTheme({
  styles: {
    global: {
      "body": {
        bg: "#3b1e1e", // Set your preferred background
        color: "white",
      },
    },
  },
});

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <ChakraProvider theme={theme}>
    <App /></ChakraProvider>
  </React.StrictMode>,
)
