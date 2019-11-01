package apps.android.fattahnexx103.takertest.model.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import apps.android.fattahnexx103.takertest.utils.DateUtil;

import static apps.android.fattahnexx103.takertest.utils.DateUtil.GET_MONTH_ERROR;
import static apps.android.fattahnexx103.takertest.utils.DateUtil.getMonthFromNumber;
import static apps.android.fattahnexx103.takertest.utils.DateUtil.monthNumbers;
import static apps.android.fattahnexx103.takertest.utils.DateUtil.months;
import static org.junit.jupiter.api.Assertions.*;

public class DateUtilTest {

    private static final String today = "11-2019";

    //return current timestamp
    @Test
    void getCurrentTimeStamp(){
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                assertEquals(today, DateUtil.getCurrentTimeStamp());
                System.out.println("Timestamp is generated correctly");
            }
        });
    }

//    public static final String[] monthNumbers = {"01","02","03","04","05","06","07","08","09","10","11","12"};
//    public static final String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    //get the correct month from the number provided = true
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9,10,11})
    void getMonthFromNumber_success(int monthNum, TestInfo testInfo, TestReporter reporter){
        assertEquals(months[monthNum],DateUtil.getMonthFromNumber(monthNumbers[monthNum])); // month and month numbers are static arrays in Date Util class
        System.out.println("Month: " + monthNumbers[monthNum] + " Month is: " + months[monthNum]);
    }

    //get the correct month from the incorrect number provided = false
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9,10,11}) // not using 0 since 0 * num would result in 0 failing our test
    void getMonthFromNumber_failure(int monthNum){
        int randomInt = new Random().nextInt(90) + 13; //lowest being 0 + 13 = 13
        assertEquals(getMonthFromNumber(String.valueOf(monthNum + randomInt)), GET_MONTH_ERROR);
        System.out.println("Month: " + monthNumbers[monthNum] + ": " + GET_MONTH_ERROR );
    }
}
