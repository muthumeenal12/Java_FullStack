import { useState } from "react";
import {
  Box,
  IconButton,
  Drawer,
  DrawerBody,
  DrawerOverlay,
  DrawerContent,
  DrawerCloseButton,
  useDisclosure,
  Button,
  VStack,
} from "@chakra-ui/react";
import { HamburgerIcon } from "@chakra-ui/icons";

const SideBar = ({ setActivePage }: { setActivePage: (page: string) => void }) => {
  const { isOpen, onOpen, onClose } = useDisclosure();
  const [active, setActive] = useState("Home");

  const handleClick = (page: string) => {
    setActive(page);
    setActivePage(page);
    onClose();
  };

  return (
    <Box>
      {/* Sidebar Toggle Button */}
      <IconButton
        aria-label="Open Sidebar"
        icon={<HamburgerIcon />}
        onClick={onOpen}
        m={4}
      />

      {/* Sidebar Drawer */}
      <Drawer isOpen={isOpen} placement="left" onClose={onClose}>
        <DrawerOverlay />
        <DrawerContent bg="gray.800" color="white">
          <DrawerCloseButton />
          <DrawerBody>
            <VStack align="start" spacing={4} mt={10}>
              {["Home", "About", "Contact Us"].map((page) => (
                <Button
                  key={page}
                  w="full"
                  variant={active === page ? "solid" : "ghost"}
                  colorScheme="blue"
                  onClick={() => handleClick(page)}
                >
                  {page}
                </Button>
              ))}
            </VStack>
          </DrawerBody>
        </DrawerContent>
      </Drawer>
    </Box>
  );
};

export default SideBar;
