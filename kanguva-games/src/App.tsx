import { useState } from "react";
import { Grid, GridItem } from "@chakra-ui/react";
import NavBar from "./NavBar";
import SideBar from "./components/SideBar";
import GameCards from "./components/GameCards";
import About from "./components/About";
import Contact from "./components/Contact";

function App() {
  const [activePage, setActivePage] = useState("Home");

  return (
    <Grid
      templateAreas={`"nav nav"
                      "side main"`}
      gridTemplateRows={"90px 1fr"}
      gridTemplateColumns={"200px 1fr"}
      h="100vh"
    >
      {/* Navbar */}
      <GridItem area={"nav"} bg={"black"} p={4} color="white">
        <NavBar />
      </GridItem>

      {/* Sidebar */}
      <GridItem area={"side"} bg={"teal"} p={4} color="white">
        <SideBar setActivePage={setActivePage} />
      </GridItem>

      {/* Main Content - Change Based on Active Page */}
      <GridItem area={"main"} p={4}>
        {activePage === "Home" && <GameCards />}
        {activePage === "About" && <About />}
        {activePage === "Contact Us" && <Contact/>}
      </GridItem>
    </Grid>
  );
}

export default App;
