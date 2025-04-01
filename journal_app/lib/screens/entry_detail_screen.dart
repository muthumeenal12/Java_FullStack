import 'package:flutter/material.dart';

class EntryDetailScreen extends StatelessWidget {
  final String title;
  final String content;
  final String date;

  const EntryDetailScreen({super.key, required this.title, required this.content, required this.date});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Journal Entry')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(title, style: Theme.of(context).textTheme.headlineLarge),
            const SizedBox(height: 8),
            Text(date, style: Theme.of(context).textTheme.bodySmall),
            const Divider(),
            Expanded(
              child: SingleChildScrollView(
                child: Text(content, style: Theme.of(context).textTheme.bodyLarge),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
