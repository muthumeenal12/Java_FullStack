import { FormControl, FormLabel, Select, Button, Input } from "@chakra-ui/react";
import React, { useState, useEffect } from "react";
import axios from "axios";

interface ChocolateFormProps {
  onAddChocolate: (chocolate: Chocolate) => void;
}

const ChocolateForm: React.FC<ChocolateFormProps> = ({ onAddChocolate }) => {
  const [name, setName] = useState("");
  const [brand, setBrand] = useState("");
  const [price, setPrice] = useState<number | "">("");
  const [weight, setWeight] = useState<number | "">("");
  const [brands, setBrands] = useState<Brand[]>([]);

  // Fetch brands from API
  useEffect(() => {
    axios
      .get("http://localhost:4500/brands") // Ensure this matches your API endpoint
      .then((response) => setBrands(response.data))
      .catch((error) => console.error("Error fetching brands:", error));
  }, []);

  const handleSubmit = () => {
    if (!name || !brand || price === "" || weight === "") return;

    const newChocolate: Chocolate = {
      id: crypto.randomUUID(),
      name,
      brand,
      price: Number(price),
      weight: Number(weight),
    };

    onAddChocolate(newChocolate);
    setName("");
    setBrand("");
    setPrice("");
    setWeight("");
  };

  return (
    <FormControl>
      <FormLabel>Chocolate Name</FormLabel>
      <Input value={name} onChange={(e) => setName(e.target.value)} placeholder="Enter chocolate name" />

      <FormLabel>Select Chocolate Brand</FormLabel>
      <Select placeholder="Select brand" value={brand} onChange={(e) => setBrand(e.target.value)}>
        {brands.map((brand) => (
          <option key={brand.id} value={brand.name}>
            {brand.name}
          </option>
        ))}
      </Select>

      <FormLabel>Price</FormLabel>
      <Input type="number" value={price} onChange={(e) => setPrice(Number(e.target.value))} placeholder="Enter price" />

      <FormLabel>Weight (grams)</FormLabel>
      <Input type="number" value={weight} onChange={(e) => setWeight(Number(e.target.value))} placeholder="Enter weight" />

      <Button mt={4} colorScheme="blue" onClick={handleSubmit}>
        Add Chocolate
      </Button>
    </FormControl>
  );
};

export default ChocolateForm;
