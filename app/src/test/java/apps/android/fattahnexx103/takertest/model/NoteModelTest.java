package apps.android.fattahnexx103.takertest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteModelTest {

    public static final String TIMESTAMP_1 = "05-2019";
    public static final String TIMESTAMP_2 = "04-2019";

    //we are testing the equals method in the note model class

    //compare 2 equal notes = true
    @Test
    void isEqualNotesObjects_identicalProps() throws  Exception{
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);
        Note note2 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note2.setId(1);

        assertEquals(note1,note2);
        System.out.println("The notes are equal with identical props"); //if it fails it wont even reach this line
    }



    //compare notes with 2 different ids = false
    @Test
    void isEqualNotesObjects_differentIds() throws Exception{
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);
        Note note2 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note2.setId(2);

        assertNotEquals(note1,note2);
        System.out.println("The notes are not equal with diff ids");
    }

    //compare 2 notes with diff timestamps = true (since we dont care bout timestamp)
    @Test
    void isEqualNotesObjects_differentTimeStamps() throws Exception{
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);
        Note note2 = new Note("Note #1", "This is note #1", TIMESTAMP_2);
        note2.setId(1);

        assertEquals(note1,note2);
        System.out.println("The notes are equal with diff timestamps"); //if it fails it wont even reach this line
    }

    //compare 2 notes with diff titles = false
    @Test
    void isEqualNotesObjects_differentTitles() throws Exception{
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);
        Note note2 = new Note("Note #2", "This is note #1", TIMESTAMP_2);
        note2.setId(1);

        assertNotEquals(note1,note2);
        System.out.println("The notes are not equal with diff titles"); //if it fails it wont even reach this line
    }


    //compare 2 notes with diff content = false
    @Test
    void isEqualNotesObjects_differentContent() throws Exception{
        Note note1 = new Note("Note #1", "This is note #1", TIMESTAMP_1);
        note1.setId(1);
        Note note2 = new Note("Note #2", "This is note #2", TIMESTAMP_2);
        note2.setId(1);

        assertNotEquals(note1,note2);
        System.out.println("The notes are not equal with diff contents"); //if it fails it wont even reach this line
    }
}
