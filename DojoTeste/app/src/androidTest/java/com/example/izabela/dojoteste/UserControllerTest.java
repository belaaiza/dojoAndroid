package com.example.izabela.dojoteste;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import android.test.ActivityInstrumentationTestCase2;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import com.example.izabela.dojoteste.controller.MainActivity;
import com.example.izabela.dojoteste.model.User;

import org.junit.Before;

/**
 * Created by izabela on 19/05/16.
 */
public class UserControllerTest extends ActivityInstrumentationTestCase2<MainActivity>{

    public UserControllerTest(){
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        getActivity();
    }

    public void testValidUserRegistration() {

        onView(withId(R.id.nameEditText)).perform(typeText("Izabela"));
        onView(withId(R.id.ageEditText)).perform(typeText("18"));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.welcomeTextView)).check(matches(isDisplayed()));
    }

    public  void testInvalidUserNameRegistration() {
        onView(withId(R.id.nameEditText)).perform(typeText("ksdçjgaçijfgvbadfjvbçakdfbvdklfvbdzlfvblzkdfbvzdlkfvbdzlkfvbdzlkfvbdzlkfjvbdzlkvbzkdfvbzdkl"));
        onView(withId(R.id.ageEditText)).perform(typeText("18"));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.nameEditText)).check(matches(hasErrorText("Digite um nome de até 50 caracteres")));



    }
}
