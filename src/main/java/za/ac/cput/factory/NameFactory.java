/*

Student Name: Nondumiso Gaga
Student Number: 220430853
NameFactory class
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Name;
import za.ac.cput.helper.StringHelper;

public class NameFactory {

    public static Name buildName (String firstName,String middleName,String lastName){
        StringHelper.checkStringParam("firstName" ,firstName);
        StringHelper.setEmptyIfNull(middleName);
        StringHelper.checkStringParam("lastName" ,lastName);

        return new Name.Builder().setFirstName(firstName).setMiddleName(middleName)
                .setLastName(lastName).build();
    }

}
