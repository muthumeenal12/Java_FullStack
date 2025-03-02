import { Box, Image, Text, Badge } from "@chakra-ui/react";
import { Game } from "./types";

interface GameCardProps {
  game: Game;
}

const GameCard: React.FC<GameCardProps> = ({ game }) => {
  return (
    <Box
      borderWidth="1px"
      borderRadius="lg"
      overflow="hidden"
      boxShadow="lg"
      transition="0.3s"
      _hover={{ transform: "scale(1.05)" }}
      p={4}
      bg="gray.800"
      color="white"
    >
      <Image
        src={game.background_image}
        alt={game.name}
        borderRadius="md"
        fallbackSrc="https://via.placeholder.com/300"
      />
      <Text fontSize="lg" fontWeight="bold" mt={2}>
        {game.name}
      </Text>
      <Badge colorScheme="green" mt={1}>
        ⭐ {game.rating.toFixed(1)}
      </Badge>
      <Text fontSize="sm" color="gray.400">
        Released: {game.released}
      </Text>
    </Box>
  );
};

export default GameCard;
