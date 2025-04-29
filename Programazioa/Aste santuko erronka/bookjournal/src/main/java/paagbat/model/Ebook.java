package paagbat.model;

import paagbat.model.base.BaseBook;
import paagbat.model.enums.BookFormat;
import paagbat.model.enums.Genre;

public class Ebook extends BaseBook {
    public Ebook(int id, String title, String author, Genre genre, int duration) {
        super(id, title, author, genre, duration, BookFormat.EBOOK);
    }

    @Override
    public String getExtraInfo() {
        return "Formato ebook";
    }
}
