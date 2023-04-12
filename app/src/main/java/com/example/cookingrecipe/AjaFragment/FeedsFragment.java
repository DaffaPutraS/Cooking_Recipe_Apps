package com.example.cookingrecipe.AjaFragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cookingrecipe.R;

import java.util.ArrayList;
import java.util.List;

import AjaAdapter.MyAdapter;
import AjaClassGetSet.DataClass;

public class FeedsFragment extends Fragment {

    // deklarasi variabel
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter myAdapter;
    DataClass androidData;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_feeds, container, false);

        //Inisialisasi SearchView dengan id searchbar yang ada pada fragment_feeds.xml
        //Inisialisasi RecyclerView dengan id recyclerview yang ada pada fragment_feeds.xml
        searchView = view.findViewById(R.id.searchbar);
        recyclerView = view.findViewById(R.id.recyclerview);

        //Menghilangkan fokus dari SearchView
        searchView.clearFocus();
        //Memberikan listener pada saat teks pada SearchView berubah
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Mencari list yang sesuai dengan teks yang diinputkan pada SearchView
                searchList(newText);
                return true;
            }
        });
        // Menentukan layout manager dan adapter untuk RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager); //Mengatur layout manager untuk RecyclerView
        dataList = new ArrayList<>(); //Inisialisasi dataList dengan ArrayList
        // Menambahkan data makanan Paella ke dalam ArrayList dataList
        androidData = new DataClass("Paella", "• Onion, 1 pc, finely chopped\n" +
                "• Garlic, 2 cloves, finely chopped\n" +
                "• Peppers, 1 fruit, thinly sliced\n" +
                "• Tomatoes, 2 pieces, diced\n" +
                "• Paella rice or medium grain rice, 500 grams\n" +
                "• Chicken stock, 1 liter\n" +
                "• Peas, 100 grams\n" +
                "• Shrimp, 250 grams, peeled and removed the head and skin\n" +
                "• Scallops, 250 grams\n" +
                "• Saffron, 1 tsp\n" +
                "• Salt to taste\n" +
                "• Olive oil, 3 tablespoons\n", "→ 1. Heat olive oil in a paella pan or large flat skillet over medium heat.\n" +
                "→ 2. Sauté the onions and garlic until fragrant.\n" +
                "→ 3. Add the peppers and tomatoes, stir well and cook until the tomatoes are soft.\n" +
                "→ 4. Add the rice and stir well with the spices until the rice is perfectly coated.\n" +
                "→ 5. Add the chicken broth and saffron, stir well, and let it simmer.\n" +
                "→ 6. After boiling, add the prawns, clams, and peas, stir well, and let everything cook and the water is completely absorbed.\n" +
                "→ 7. If the rice is still not cooked and lacks water, add a little stock and continue to cook until the rice is cooked.\n" +
                "→ 8. Remove from the heat and let the Paella rest for a few minutes before serving.\n" +
                "→ 9. Serve warm Paella with lemon wedges and other dishes according to taste.\n", R.drawable.paella);
        dataList.add(androidData);
        androidData = new DataClass("Pad Thai", "• Rice noodles, 200 grams\n" +
                "• Shrimp, 150 grams\n" +
                "• Bean sprouts, 100 grams\n" +
                "• Garlic, 2 cloves\n" +
                "• Red chili, 2 pcs\n" +
                "• Peanuts, 50 grams\n" +
                "• Sweet soy sauce, 3 tablespoons\n" +
                "• Lime juice, 2 tablespoons\n" +
                "• Brown sugar, 2 tablespoons\n" +
                "• Salt to taste\n" +
                "• Vegetable oil, to taste\n", "→ 1. Soak rice noodles in cold water for about 30 minutes until soft. Drain and set aside.\n" +
                "→ 2. Slice the garlic and red chilies. Coarsely chop the peanuts.\n" +
                "→ 3. Heat vegetable oil in a skillet over medium heat. Saute garlic and red chili until fragrant.\n" +
                "→ 4. Add prawns and stir-fry until it changes color.\n" +
                "→ 5. Add rice noodles, bean sprouts and peanuts. Stir well.\n" +
                "→ 6. Add sweet soy sauce, lime juice, brown sugar and salt. Stir well until the spices are absorbed and the noodles are cooked.\n" +
                "→ 7. Remove and serve the Pad Thai on a plate. Sprinkle with chopped peanuts and sliced celery or chives.\n" +
                "→ 8. Enjoy some delicious Pad Thai!\n", R.drawable.pad_thai);
        dataList.add(androidData);
        androidData = new DataClass("Fried rice", "• White rice, 2 bowls\n" +
                "• Cooking oil, 2 tablespoons\n" +
                "• Garlic, 2 cloves (finely chopped)\n" +
                "• Shallots, 2 cloves (finely chopped)\n" +
                "• Red chili, 2 pieces (finely chopped)\n" +
                "• Chicken eggs, 2 eggs (shake off)\n" +
                "• Sweet soy sauce, 2 tablespoons\n" +
                "• Soy sauce, 1 tablespoon\n" +
                "• Salt to taste\n" +
                "• Pepper to taste\n" +
                "• Green onions, to taste (chopped small)\n", "→ 1. Heat cooking oil in a skillet over medium heat.\n" +
                "→ 2. Sauté the garlic, shallots and red chilies until fragrant.\n" +
                "→ 3. Add beaten eggs and stir well until cooked.\n" +
                "→ 4. Add white rice to the pan and mix well with the spices.\n" +
                "→ 5. Pour in soy sauce, soy sauce, salt and pepper. Stir well and cook until the rice looks a bit dry.\n" +
                "→ 6. Lastly, sprinkle with green onions and stir well for a while.\n" +
                "→ 7. Fried rice ready to be served.\n" +
                "→ 8. Enjoy a delicious fried rice dish!\n", R.drawable.fried_rice);
        dataList.add(androidData);
        androidData = new DataClass("Fish and Chips", "• Fish fillet, 4 pieces (can use cod, haddock or other seafood)\n" +
                "• Bread flour, 1 cup\n" +
                "• Wheat flour, 1 cup\n" +
                "• Salt, 1 tsp\n" +
                "• Black pepper, 1/2 teaspoon\n" +
                "• Water, 1 cup\n" +
                "• Egg, 1 grain\n" +
                "• Potatoes, 4 pieces (sliced lengthwise like matchsticks)\n" +
                "• Vegetable oil for frying\n", "→ 1. Combine the breadcrumbs, flour, salt, and black pepper in a large bowl.\n" +
                "→ 2. Whisk eggs and water in a separate bowl.\n" +
                "→ 3. Heat vegetable oil in a skillet or deep fryer.\n" +
                "→ 4. Dip the fish pieces into the flour mixture, then into the egg mixture and finally into the breadcrumb mixture.\n" +
                "→ 5. Fry fish in hot oil until browned, about 5-7 minutes. Drain on oil paper.\n" +
                "→ 7. Fry the potato wedges until browned and crispy, about 3-5 minutes.\n" +
                "→ 8. Serve fried fish and french fries together as a main course.\n", R.drawable.fish_and_chips);
        dataList.add(androidData);
        androidData = new DataClass("Tortilla", "• Corn flour or wheat flour, 2 cups\n" +
                "• Warm water, 1 cup\n" +
                "• Salt, 1 tsp\n" +
                "• Vegetable oil, 2 tablespoons\n", "→ 1. Mix cornstarch or wheat flour with salt in a large bowl.\n" +
                "→ 2. Add warm water little by little while continuing to stir until the dough becomes soft and not sticky to your hands.\n" +
                "→ 3. Place the dough on a clean surface and roll out to 1/4 inch thick.\n" +
                "→ 4. Heat a frying pan or flat griddle over medium heat and add vegetable oil.\n" +
                "→ 5. Use a knife or cookie cutter to cut the dough into the desired round shape.\n" +
                "→ 6. Place the tortillas in the fryer or skillet and fry for about 1 minute on each side or until the tortillas are crisp and lightly browned.\n" +
                "→ 7. Remove the tortilla from the fryer or skillet and let it cool slightly before serving or using it in other dishes.\n", R.drawable.tortilla);
        dataList.add(androidData);
        androidData = new DataClass("Butternut", "• 1 butternut squash, peeled, seeded and diced small\n" +
                "• 12 sheets of dry lasagna\n" +
                "• 2 1/2 cups of tomato sauce\n" +
                "• 2 cups ricotta cheese\n" +
                "• 1 cup of grated parmesan cheese\n" +
                "• 2 tablespoons of olive oil\n" +
                "• Salt and pepper to taste\n", "→ 1. Preheat the oven to 375°F (190°C).\n" +
                "→ 2. Mix butternut squash pieces with olive oil, salt, and pepper. Bake in the oven for about 20-25 minutes or until tender.\n" +
                "→ 3. Mix the ricotta cheese with half of the grated parmesan cheese.\n" +
                "→ 4. Spread the lasagna layer on the bottom of the pan, then brush with the tomato sauce.\n" +
                "→ 5. Place the butternut squash pieces on top of the tomato sauce, then brush with the ricotta and grated Parmesan cheese mixture.\n" +
                "→ 6. Sprinkle the remaining parmesan cheese over the last layer.\n" +
                "→ 7. Cover the baking sheet with aluminum foil and bake in the oven for about 30-35 minutes.\n" +
                "→ 8. After that, open the aluminum foil and bake for another 10-15 minutes until the surface is browned.\n" +
                "→ 9. Remove from the oven and let rest 10-15 minutes before serving.\n" +
                "→ 10. Enjoy this delicious and nutritious Butternut lasagna!\n", R.drawable.butternut);
        dataList.add(androidData);
        androidData = new DataClass("Aloo Gobi", "• Potatoes, 2 medium size, diced\n" +
                "• Cauliflower, 1 medium size, cut into small pieces\n" +
                "• Vegetable oil, 2 tablespoons\n" +
                "• Minced garlic, 2 cloves\n" +
                "• Minced ginger, 1 inch\n" +
                "• Tomato, 1 medium size, cut into small cubes\n" +
                "• Salt, 1 tsp\n" +
                "• Ground coriander, 2 tsp\n" +
                "• Turmeric powder, 1 tsp\n" +
                "• Red chili powder, 1 teaspoon\n" +
                "• Water, 1/4 cup\n" +
                "• Fresh coriander leaves for sprinkling\n", "→ 1. Heat the oil in a pan.\n" +
                "→ 2. Add garlic and ginger, sauté until fragrant.\n" +
                "→ 3. Add potato wedges, cauliflower and tomatoes, mix well.\n" +
                "→ 4. Add salt, coriander powder, turmeric powder, and red chili powder, mix well.\n" +
                "→ 5. Add water and cook until the vegetables are cooked and soft.\n" +
                "→ 6. Sprinkle fresh coriander leaves over the cooked Aloo Gobi.\n" +
                "→ 7. Serve Aloo Gobi with rice or bread as a main course.\n" +
                "→ 8. Enjoy your Aloo Gobi!\n", R.drawable.aloo_gobi);
        dataList.add(androidData);
        androidData = new DataClass("Chocolate brownies", "• Dark chocolate, 200 grams\n" +
                "• Butter, 150 grams\n" +
                "• Sugar, 200 grams\n" +
                "• Chicken eggs, 3 grains\n" +
                "• Wheat flour, 100 grams\n" +
                "• Cocoa powder, 50 grams\n" +
                "• Salt, 1/4 teaspoon\n", "→ 1. Preheat the oven to 180°C.\n" +
                "→ 2. Prepare a rectangular tin and grease it with butter or line it with parchment paper.\n" +
                "→ 3. Melt dark chocolate and butter in a saucepan over low heat.\n" +
                "→ 4. Combine granulated sugar and chicken eggs in a large bowl, stir until smooth.\n" +
                "→ 5. Add the dark chocolate and butter mixture to the egg and sugar mixture, stir until smooth.\n" +
                "→ 6. Sift the flour, cocoa powder, and salt into the mixing bowl, stir until smooth and there are no lumps.\n" +
                "→ 7. Pour the brownie batter into the prepared pan, level the surface with a spatula.\n" +
                "→ 8. Bake the brownies for 20-25 minutes in the preheated oven.\n" +
                "→ 9. Once done, remove the brownies from the oven and let them cool.\n" +
                "→ 10. Slice the brownies and serve.\n" +
                "→ 11. Enjoy delicious chocolate brownies!\n", R.drawable.chocolate_brownies);
        dataList.add(androidData);
        androidData = new DataClass("Chocolate Chip Cookies", "• Unsalted butter, 115 grams (room temperature)\n" +
                "• Sugar, 100 grams\n" +
                "• Palm sugar, 100 grams\n" +
                "• Chicken egg, 1 grain (room temperature)\n" +
                "• All-purpose flour, 225 grams\n" +
                "• Baking soda, 1/2 teaspoon\n" +
                "• Salt, 1/4 teaspoon\n" +
                "• Choco chips, 200 gr\n", "→ 1. Preheat the oven to 190 degrees Celsius and prepare a baking sheet with parchment paper or grease it with butter.\n" +
                "→ 2. In a large bowl, beat the butter, granulated sugar and brown sugar until light and fluffy.\n" +
                "→ 3. Add the eggs and beat again until well mixed.\n" +
                "→ 4. In a separate bowl, mix the flour, baking soda and salt.\n" +
                "→ 5. Slowly mix the flour mixture with the butter mixture, stirring until well blended.\n" +
                "→ 6. Add choco chips and mix well.\n" +
                "→ 7. Take the dough the size of a ping pong ball and place it on the prepared baking sheet. Make sure the distance between the dough is far enough so it doesn't stick when baking.\n" +
                "→ 8. Bake in the oven for 10-12 minutes or until the edges start to brown.\n" +
                "→ 9. Remove from the oven and let cool briefly before removing from the tin and serving.\n" +
                "→ 10. Enjoy delicious chocolate chip cookies!\n", R.drawable.chocolate_chip_cookies);
        dataList.add(androidData);
        androidData = new DataClass("Chicken Karage", "• Chicken fillet, 500 grams\n" +
                "• Garlic, 4 cloves\n" +
                "• Ginger, 2 cm\n" +
                "• Salt, 1 tsp\n" +
                "• Pepper, 1/2 teaspoon\n" +
                "• Soy sauce, 1 tablespoon\n" +
                "• Potato flour, 100 grams\n" +
                "• Corn flour, 100 grams\n" +
                "• Right amount of oil\n", "→ 1. Thinly slice the garlic and ginger and grind them. Mix with salt, pepper and soy sauce.\n" +
                "→ 2. Cut the chicken meat into small pieces according to taste, then add it to the spice mixture and mix well. Let stand for 30 minutes until the flavors meld.\n" +
                "→ 3. Mix potato starch and cornstarch in a separate bowl. Roll the chicken pieces in the flour mixture until evenly distributed.\n" +
                "→ 4. Heat oil in a pan, then fry the chicken pieces until brown and cooked evenly. Lift and drain.\n" +
                "→ 5. Chicken karage is ready to be served as a main dish or as a snack. Serve with chili sauce or mayonnaise as a complement.\n" +
                "→ 6. Enjoy the delicious chicken karage!\n", R.drawable.chicken_karage);
        dataList.add(androidData);
        androidData = new DataClass("Spagheti", "• 1 pound spaghetti\n" +
                "• 6-8 cups of water\n" +
                "• Salt to taste\n" +
                "• Olive oil for cooking\n" +
                "• 2-3 garlic cloves, minced\n" +
                "• 1/4 tsp red pepper flakes (optional)\n" +
                "• 1 can (28 oz) of crushed tomatoes\n" +
                "• 1/4 cup chopped fresh basil\n" +
                "• Parmesan cheese for topping (optional)\n", "\n" +
                "→ 1. Fill a large pot with 6-8 cups of water and add salt to taste. Bring the water to a boil over high heat.\n" +
                "→ 2. Add spaghetti to the boiling water and stir well. Cook the spaghetti for 8-10 minutes or until al dente (cooked but still firm).\n" +
                "→ 3. While the spaghetti is cooking, heat olive oil in a large saucepan over medium heat. Add minced garlic and red pepper flakes (optional) and sauté for 1-2 minutes or until fragrant.\n" +
                "→ 4. Add crushed tomatoes to the saucepan and bring it to a simmer. Let the sauce simmer for 5-7 minutes or until slightly thickened.\n" +
                "→ 5. Once the spaghetti is cooked, drain it in a colander and rinse it under cold running water to stop the cooking process.\n" +
                "→ 6. Add the cooked spaghetti to the saucepan with the tomato sauce and toss it well to coat the spaghetti with the sauce.\n" +
                "→ 7. Add chopped fresh basil to the saucepan and stir well.\n" +
                "→ 8. Serve the spaghetti hot with grated Parmesan cheese on top, if desired.", R.drawable.spageti);
        dataList.add(androidData);
        androidData = new DataClass("Beef Steak", "• 1 pound beef steak (ribeye, sirloin, or filet mignon)\n" +
                "• Salt and black pepper to taste\n" +
                "• Salt to taste\n" +
                "• Olive oil for cooking\n" +
                "• 2-3 cloves of garlic, minced\n" +
                "• 2-3 sprigs of fresh thyme\n" +
                "• 2-3 tbsp butter\n" +
                "\n", "→ 1. Take the steak out of the refrigerator and let it sit at room temperature for 30 minutes before cooking.\n" +
                "→ 2. Preheat a large skillet or grill pan over medium-high heat.\n" +
                "→ 3. Season both sides of the steak with salt and black pepper to taste.\n" +
                "→ 4. Drizzle olive oil over the steak and use your hands to rub the oil all over the steak.\n" +
                "→ 5. Once the skillet is hot, place the steak on the skillet and cook for 4-5 minutes per side for medium-rare, or adjust the time to your desired level of doneness.\n" +
                "→ 6. Add minced garlic, fresh thyme, and butter to the skillet during the last 2 minutes of cooking, and use a spoon to baste the steak with the butter and aromatics.\n" +
                "→ 7. Once the steak is cooked to your liking, remove it from the skillet and let it rest for 5 minutes on a cutting board.\n" +
                "→ 8. Slice the steak against the grain into 1/2-inch slices and serve it hot with your favorite sides.", R.drawable.beef_steak);
        dataList.add(androidData);
        androidData = new DataClass("BBQ sauce fried chicken", "• 4 boneless, skinless chicken breasts\n" +
                "• 1 cup all-purpose flour\n" +
                "• 1 tsp paprika\n" +
                "• 1 tsp garlic powder\n" +
                "• 1/2 tsp salt\n" +
                "• 1/2 tsp black pepper\n" +
                "• 1/2 tsp black pepper\n" +
                "• 2 eggs, beaten\n" +
                "• 1/2 cup BBQ sauce\n" +
                "• 1/4 cup vegetable oil\n" +
                "• Chopped fresh parsley for garnish\n", "→ 1. Preheat the oven to 350°F (175°C).\n" +
                "→ 2. In a shallow dish, combine all-purpose flour, paprika, garlic powder, salt, and black pepper. Mix well.\n" +
                "→ 3. Dip each chicken breast in beaten eggs, and then dredge it in the flour mixture until coated evenly.\n" +
                "→ 4. Heat vegetable oil in a large skillet over medium-high heat. Add the chicken breasts and cook for 4-5 minutes per side or until golden brown and crispy.\n" +
                "→ 5. Remove the chicken breasts from the skillet and place them on a baking sheet.\n" +
                "→ 6. Brush BBQ sauce evenly over each chicken breast.\n" +
                "→ 7. Bake the chicken in the preheated oven for 10-15 minutes or until the internal temperature reaches 165°F (74°C).\n" +
                "→ 8. Garnish the chicken with chopped fresh parsley and serve hot.", R.drawable.bbq_friedchkn);
        dataList.add(androidData);
        myAdapter = new MyAdapter(getActivity(), dataList);
        recyclerView.setAdapter(myAdapter);
        return view;
    }

    // method untuk melakukan search pada data yang ditampilkan pada recyclerview
    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(getActivity(), "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            myAdapter.setSearchList(dataSearchList);
        }
    }
}