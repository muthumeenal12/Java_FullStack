import 'dart:convert';
import 'package:http/http.dart' as http;

Future<String> fetchRandomQuote() async {
  const String apiUrl = "https://zenquotes.io/api/random";

  try {
    final response = await http.get(Uri.parse(apiUrl));

    if (response.statusCode == 200) {
      final List<dynamic> data = json.decode(response.body);
      return data[0]['q']; // Extract the quote text
    } else {
      return "Believe in yourself and keep going!"; // Fallback message
    }
  } catch (e) {
    return "Could not fetch a quote. Stay strong!"; // Error message
  }
}
