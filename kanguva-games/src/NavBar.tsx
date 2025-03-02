import { Heading, HStack, Image } from "@chakra-ui/react";
import logo from "./assets/logochange.png";
import DarkSwitch from "./components/DarkSwitch";
function NavBar() {
  return <>
  <HStack justifyContent={"space-between"}>
    <Image src ={logo} boxSize="75px" ></Image>
    <Heading>Kanguva Games</Heading>
    <DarkSwitch/>
  </HStack>
  </>;
}
export default NavBar;
