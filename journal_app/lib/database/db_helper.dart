import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DBHelper {
  static Database? _database;

  static Future<Database> getDatabase() async {
    if (_database != null) return _database!;

    _database = await openDatabase(
      join(await getDatabasesPath(), 'journal.db'),
      onCreate: (db, version) {
        return db.execute(
          "CREATE TABLE entries(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, date TEXT)",
        );
      },
      version: 1,
    );

    return _database!;
  }

  // ✅ **This is the function you need**
  static Future<int> insertEntry(Map<String, dynamic> entry) async {
    final db = await getDatabase();
    return await db.insert('entries', entry, conflictAlgorithm: ConflictAlgorithm.replace);
  }

  static Future<List<Map<String, dynamic>>> getEntries() async {
    final db = await getDatabase();
    return await db.query('entries', orderBy: "id DESC");
  }
  static Future<int> updateEntry(int id, Map<String, dynamic> entry) async {
  final db = await getDatabase();
  return await db.update(
    'entries',
    entry,
    where: "id = ?",
    whereArgs: [id],
  );
}

static Future<int> deleteEntry(int id) async {
  final db = await getDatabase();
  return await db.delete(
    'entries',
    where: "id = ?",
    whereArgs: [id],
  );
}

}
