import { HStack, Switch, useColorMode } from "@chakra-ui/react";

function DarkSwitch() {
  let { colorMode, toggleColorMode } = useColorMode();
  return (
    <HStack>
      <Switch
        colorScheme="orange"
        isChecked={colorMode == "dark"}
        onChange={toggleColorMode}
      >
        Theme
      </Switch>
    </HStack>
  );
}
export default DarkSwitch;
