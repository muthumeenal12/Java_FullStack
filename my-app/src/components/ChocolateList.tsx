import React, { useState } from "react";
import { Button, Box, List, ListItem, Text, HStack, useToast } from "@chakra-ui/react";
import { DeleteIcon } from "@chakra-ui/icons"; // Import DeleteIcon
import "./chocolate-list.css";
import { FiShoppingBag } from "react-icons/fi";


interface Props {
  chocolates: Chocolate[];
  onDelete: (id: string) => void;
}

const ChocolateList: React.FC<Props> = ({ chocolates, onDelete }) => {
const toast = useToast();
  const handleBuy = (chocolateName:string) => {
    toast({
      title:"Purchase Successful!",
      description:`You bought ${chocolateName}`,
      status: "success",
      duration: 2000,
      isClosable: true,
    })
  };

  return (
    <div className="chocolate-list-container">
      <h2>Chocolate List</h2>
      {/* {showConfetti && <Confetti />} */}

      <ul className="chocolate-list">
        {chocolates.map((chocolate) => (
          <li key={chocolate.id} className="chocolate-item">
            <span>
              {chocolate.name} - {chocolate.brand} - ₹{chocolate.price} - {chocolate.weight}
            </span>
            <div className="button-group">
              <button className="chocolate-btn buy-btn" onClick={()=>handleBuy(chocolate.name)}>
               <FiShoppingBag/>
              </button>
              <button className="chocolate-btn delete-btn" onClick={() => onDelete(chocolate.id)}>
                <DeleteIcon /> {/* Replace text with DeleteIcon */}
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ChocolateList;
