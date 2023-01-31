package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJob = new Job("Data Scientist", new Employer("Tesla"), new Location("Alaska"), new PositionType("Entry level"), new CoreCompetency("A.I"));
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(testJob.getId(), job1.getId());

    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", productTester.getName());
        assertEquals("ACME", productTester.getEmployer().getValue());
        assertEquals("Desert", productTester.getLocation().getValue());
        assertEquals("Quality control", productTester.getPositionType().getValue());
        assertEquals("Persistence", productTester.getCoreCompetency().getValue());
        assertTrue(productTester.getEmployer() instanceof Employer);
        assertTrue(productTester.getLocation() instanceof Location);
        assertTrue(productTester instanceof Job);
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job Job1 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Id: 1\n" + "Name: Product tester\n" + "Employer: Data not available\n" + "Location: Desert\n" + "PositionType: Quality control\n" + "CoreCompetency: Persistence", Job1.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job Job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Id: 1\n" + "Name: Product tester\n" + "Employer: ACME\n" + "Location: Desert\n" + "PositionType: Quality control\n" + "CoreCompetency: Persistence", Job1.toString());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

    }

}
