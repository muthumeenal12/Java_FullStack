import 'package:flutter/material.dart';
import 'package:journal_app/database/db_helper.dart';

class AddEntryScreen extends StatefulWidget {
  final Map<String, dynamic>? entry;

  const AddEntryScreen({super.key, this.entry});

  @override
  State<AddEntryScreen> createState() => _AddEntryScreenState();
}

class _AddEntryScreenState extends State<AddEntryScreen> {
  final _formKey = GlobalKey<FormState>();
  late TextEditingController _titleController;
  late TextEditingController _contentController;
  bool isEditing = false;
  bool isLoading = false;

  @override
  void initState() {
    super.initState();
    isEditing = widget.entry != null;
    _titleController = TextEditingController(text: isEditing ? widget.entry!['title'] : '');
    _contentController = TextEditingController(text: isEditing ? widget.entry!['content'] : '');
  }

  Future<void> _saveEntry() async {
    if (!_formKey.currentState!.validate()) return;

    setState(() => isLoading = true);
    FocusScope.of(context).unfocus(); // Close keyboard

    String title = _titleController.text.trim();
    String content = _contentController.text.trim();
    String date = DateTime.now().toString();

    if (isEditing) {
      await DBHelper.updateEntry(widget.entry!['id'], {'title': title, 'content': content, 'date': date});
    } else {
      await DBHelper.insertEntry({'title': title, 'content': content, 'date': date});
    }

    setState(() => isLoading = false);

    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
      content: Text(isEditing ? "Entry Updated!" : "Entry Added!"),
    ));
    Navigator.pop(context, true);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(isEditing ? "Edit Journal Entry" : "Add Journal Entry")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                controller: _titleController,
                decoration: const InputDecoration(
                  labelText: "Title",
                  border: OutlineInputBorder(),
                ),
                validator: (value) {
                  if (value == null || value.trim().isEmpty) return "Title cannot be empty!";
                  if (value.length < 3) return "Title must be at least 3 characters!";
                  return null;
                },
              ),
              const SizedBox(height: 16),
              TextFormField(
                controller: _contentController,
                decoration: const InputDecoration(
                  labelText: "Content",
                  border: OutlineInputBorder(),
                ),
                maxLines: 5,
                validator: (value) => value == null || value.trim().isEmpty ? "Content cannot be empty!" : null,
              ),
              const SizedBox(height: 20),
              isLoading
                  ? const CircularProgressIndicator()
                  : ElevatedButton(
                      onPressed: _saveEntry,
                      child: Text(isEditing ? "Update Entry" : "Save Entry"),
                    ),
            ],
          ),
        ),
      ),
    );
  }
}
