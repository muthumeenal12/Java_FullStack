import { PhoneIcon, EmailIcon } from "@chakra-ui/icons";
import { Heading, Box, Text, VStack, Link, Icon } from "@chakra-ui/react";
import { FaWhatsapp } from "react-icons/fa";

const Contact = () => {
  return (
    <Box p={4} maxW="400px" borderWidth="1px" borderRadius="lg" boxShadow="md">
      <Heading size="lg" mb={4}>
         Contact Us
      </Heading>

      <VStack align="start" spacing={3}>
        <Text>
          <PhoneIcon mr={2} /> Phone:{" "}
          <Link href="tel:+1234567890" color="blue.500">
            +1 234 567 890
          </Link>
        </Text>

        <Text>
          <EmailIcon mr={2} /> Email:{" "}
          <Link href="mailto:contact@example.com" color="blue.500">
            contact@example.com
          </Link>
        </Text>

        <Text>
          <Icon as={FaWhatsapp} color="green.500" mr={2} /> WhatsApp:{" "}
          <Link href="https://wa.me/1234567890" color="blue.500" isExternal>
            Chat with us
          </Link>
        </Text>
      </VStack>
    </Box>
  );
};

export default Contact;
