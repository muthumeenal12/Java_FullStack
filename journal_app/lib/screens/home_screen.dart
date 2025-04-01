import 'package:flutter/material.dart';
import 'package:journal_app/database/db_helper.dart';
import 'package:journal_app/screens/add_entry_screen.dart';
import 'package:journal_app/utils/quotes_list.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  late Future<List<Map<String, dynamic>>> _entries;
  String _quote = "Fetching quote...";

  @override
  void initState() {
    super.initState();
    _loadEntries();
    _fetchQuote();
  }

  void _loadEntries() {
    setState(() {
      _entries = DBHelper.getEntries();
    });
  }

  Future<void> _fetchQuote() async {
    String quote = await fetchRandomQuote();
    setState(() {
      _quote = quote;
    });
  }

  Future<void> _deleteEntry(int id) async {
    await DBHelper.deleteEntry(id);
    _loadEntries();
  }

  void _navigateToAddEntry({Map<String, dynamic>? entry}) async {
    final result = await Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => AddEntryScreen(entry: entry),
      ),
    );

    if (result == true) {
      _loadEntries();
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey[900],
      appBar: AppBar(
        title: const Text("Journal Entries", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
        backgroundColor: Colors.deepPurple,
        centerTitle: true,
      ),
      body: Column(
        children: [
          // Display Motivational Quote
          Container(
            padding: const EdgeInsets.all(16.0),
            margin: const EdgeInsets.all(12.0),
            decoration: BoxDecoration(
              gradient: LinearGradient(colors: [Colors.deepPurple, Colors.purpleAccent]),
              borderRadius: BorderRadius.circular(12),
              boxShadow: [
                BoxShadow(
                  color: Colors.black26,
                  blurRadius: 6,
                  spreadRadius: 2,
                ),
              ],
            ),
            child: Text(
              _quote,
              style: const TextStyle(
                fontSize: 18,
                fontStyle: FontStyle.italic,
                color: Colors.white,
                fontWeight: FontWeight.w500,
              ),
              textAlign: TextAlign.center,
            ),
          ),

          const Divider(color: Colors.white70),

          // Display Journal Entries
          Expanded(
            child: FutureBuilder<List<Map<String, dynamic>>>(
              future: _entries,
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return const Center(child: CircularProgressIndicator(color: Colors.purpleAccent));
                } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
                  return const Center(
                    child: Text(
                      "No journal entries yet.",
                      style: TextStyle(fontSize: 18, color: Colors.white70),
                    ),
                  );
                }

                final entries = snapshot.data!;
                return ListView.builder(
                  itemCount: entries.length,
                  itemBuilder: (context, index) {
                    final entry = entries[index];
                    return Card(
                      color: Colors.deepPurple.shade400,
                      elevation: 4,
                      margin: const EdgeInsets.symmetric(horizontal: 12, vertical: 8),
                      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
                      child: ListTile(
                        title: Text(
                          entry['title'],
                          style: const TextStyle(
                            fontWeight: FontWeight.bold,
                            color: Colors.white,
                            fontSize: 18,
                          ),
                        ),
                        subtitle: Text(
                          entry['date'],
                          style: const TextStyle(color: Colors.white70),
                        ),
                        onTap: () => _navigateToAddEntry(entry: entry),
                        trailing: IconButton(
                          icon: const Icon(Icons.delete, color: Colors.redAccent),
                          onPressed: () => _deleteEntry(entry['id']),
                        ),
                      ),
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => _navigateToAddEntry(),
        backgroundColor: Colors.purpleAccent,
        child: const Icon(Icons.add, color: Colors.white),
      ),
    );
  }
}
