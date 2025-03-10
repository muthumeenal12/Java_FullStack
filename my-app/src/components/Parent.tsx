import React, { useState, useEffect } from "react";
import ChocolateList from "./ChocolateList";
import ChocolateForm from "./ChocolateForm";
import axios from "axios";


interface Chocolate {
  id: string;
  name: string;
  brand: string;
  price: number;
  weight: number;
}

const Parent: React.FC = () => {
  const [chocolates, setChocolates] = useState<Chocolate[]>([]);

  // Fetch chocolates from API on mount
  useEffect(() => {
    axios
      .get("http://localhost:4500/chocolates")
      .then((response) => setChocolates(response.data))
      .catch((error) => console.error("Error fetching chocolates:", error));
  }, []);

  // Add Chocolate
  const addChocolate = (newChocolate: Chocolate) => {
    axios
      .post("http://localhost:4500/chocolates", newChocolate)
      .then((response) => setChocolates([...chocolates, response.data]))
      .catch((error) => console.error("Error adding chocolate:", error));
  };

  // Delete Chocolate
  const deleteChocolate = (id: string) => {
    axios
      .delete(`http://localhost:4500/chocolates/${id}`)
      .then(() => setChocolates(chocolates.filter((choco) => choco.id !== id)))
      .catch((error) => console.error("Error deleting chocolate:", error));
  };

  return (
    <div className="container mt-5">
      <h1 className="text-center" style={{ color: "chocolate" }}>Chocolate Store 🍫</h1>
      <ChocolateForm onAddChocolate={addChocolate} />
      <ChocolateList chocolates={chocolates} onDelete={deleteChocolate} />
    </div>
  );
};

export default Parent;
