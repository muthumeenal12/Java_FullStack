import { useState, useEffect } from "react";
import { Box, SimpleGrid, Heading, Button, Spinner } from "@chakra-ui/react";
import GameCard from "./GameCard";
import { Game } from "./types";

const API_KEY = "1a4351ecbda847da9dec056b61d349c3"; // Replace with your API key
const BASE_URL = `https://api.rawg.io/api/games?key=${API_KEY}`;

const GameCards: React.FC = () => {
  const [games, setGames] = useState<Game[]>([]);
  const [page, setPage] = useState<number>(1);
  const [loading, setLoading] = useState<boolean>(false);

  const fetchGames = async (pageNumber: number) => {
    setLoading(true);
    try {
      const response = await fetch(`${BASE_URL}&page=${pageNumber}`);
      const data = await response.json();
      setGames((prevGames) => [...prevGames, ...data.results]);
    } catch (error) {
      console.error("Error fetching games:", error);
    }
    setLoading(false);
  };

  useEffect(() => {
    fetchGames(page);
  }, [page]);

  return (
    <Box p={5}  minH="100vh">
      <Heading mb={4}>
        Game List
      </Heading>
      <SimpleGrid columns={[1, 2, 3, 4]} spacing={5}>
        {games.map((game) => (
          <GameCard key={game.id} game={game} />
        ))}
      </SimpleGrid>

      {/* Load More Button */}
      <Box textAlign="center" mt={4}>
        {loading ? (
          <Spinner size="lg" color="white" />
        ) : (
          <Button colorScheme="blue" onClick={() => setPage(page + 1)}>
            Load More
          </Button>
        )}
      </Box>
    </Box>
  );
};

export default GameCards;
