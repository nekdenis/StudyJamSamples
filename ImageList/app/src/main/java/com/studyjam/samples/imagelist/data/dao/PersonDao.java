package com.studyjam.samples.imagelist.data.dao;

import com.studyjam.samples.imagelist.data.dto.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        for (int i=0; i<5; i++) {
            persons.add(new Person("Jake Wharton", "https://lh5.googleusercontent.com/-MPF7hSJNtf8/UMFODfjoJsI/AAAAAAAAOlo/7LumYExHE-U/w1296-h1293-no/IMG_2064.JPG"));
            persons.add(new Person("Chris Banes", "https://lh4.googleusercontent.com/-vCdsJs68-QY/VAQzjT_e0-I/AAAAAAAAgqI/2J-9nBub4Vs/w1291-h1293-no/IMG_20140819_130837.jpg"));
            persons.add(new Person("Jeremy Feinstein", "https://lh5.googleusercontent.com/-9g6iz88YAa0/UQtJEM0Xq1I/AAAAAAAADkc/_qRxLgvtr2o/s1050-no/me2.jpg"));
            persons.add(new Person("Cyril Mottier", "https://lh6.googleusercontent.com/-LWYaRkiLVvM/Ut48DO9cP1I/AAAAAAAAQkU/HvZg4UrVXtI/s900-no/me.jpg"));
            persons.add(new Person("James Smith", "https://pbs.twimg.com/profile_images/3047332419/753cf8893f242bb0013a316350a03ad0.png"));
            persons.add(new Person("Roman Nurik", "https://lh3.googleusercontent.com/-feMARDy2Efc/TXV7MjvV3gI/AAAAAAAASNo/DlZ6HoGwVs0/s738-no/avatar.jpg"));
            persons.add(new Person("Philippe Breault", "https://lh4.googleusercontent.com/-a1LzCqYfdSs/VCnP96U9uXI/AAAAAAAAN3o/IfJIWoHR_L8/w1043-h1044-no/D_ymUCOBJoLEVNWQF-m_9J0JcCT8PTeZYJpcL2XKO1o%2CLrw5tNyXrS1wGi3E-G4jU3Htys-8M-XVGx0RQl8lmBY%2CLQ2ByNSMnrkJlzZ6U2n-_z04AFm23PzbH4zTb58UJts%2CXI1FIrrDNve6tVz1UbeB5CkSSODQiAmawdXm32kOmaY.jpg"));
            persons.add(new Person("Wolfram Rittmeyer", "https://lh4.googleusercontent.com/-3TYqiebbIKU/UjM5fsbZk6I/AAAAAAAAAaI/7uqY1Jw5GVU/w1010-h1012-no/wolfram_rittmeyer-600x700.tif"));
            persons.add(new Person("Romain Guy", "https://lh4.googleusercontent.com/-a9rwPGLhqTQ/TuvSAyf_EfI/AAAAAAAAM_4/QfKSzBOXB5Y/w1295-h1293-no/Video%2Bmaking.jpg"));
            persons.add(new Person("Alex Lockwood", "https://lh5.googleusercontent.com/-qnn6saGHCNc/T8_LP_552LI/AAAAAAAAJI8/mwnsEmLzOMs/w1151-h1147-no/534892_2145006864859_1028552204_n.jpg"));
            persons.add(new Person("Lars Vogel", "https://lh5.googleusercontent.com/-E_mr7rEw5Hg/TeHZpkzVFpI/AAAAAAAABXI/PMZNvkgg4BA/w1064-h1061-no/LarsVogelArticle7.png"));
            persons.add(new Person("Chet Haase", "https://lh5.googleusercontent.com/-YGALbo_gq4U/U9mTacw7pjI/AAAAAAAAz5I/2m7sGr8uLXQ/s396-no/chet_headshot.jpg"));
            persons.add(new Person("Dave Smith", "https://lh6.googleusercontent.com/-3P53oqD-wOc/UwgYrfwZuWI/AAAAAAAAAgw/-bKkz4PWWpM/s461-no/8ee200fd-5121-4a39-928a-f0082a1060e7"));
        }
        return persons;
    }
}
