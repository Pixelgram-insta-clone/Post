package com.cognizant.Post.repository;

import com.cognizant.Post.model.Post;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostRepoTest {

    private List<Post> posts = new ArrayList<>();
    private PageRequest pageable;
    private SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    private LocalDate date = LocalDate.now();

    @BeforeAll
    void init(){

        posts.add(new Post(1, 1, "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2021%2F07%2F13%2FUltimate-Veggie-Burgers-FT-Recipe-0821.jpg&q=60", "Food at McDonalds was great! Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nam distinctio quaerat.", date));
        posts.add(new Post(2, 2, "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F47%2F2021%2F03%2F09%2Fchihuahua-laying-down-wooden-floor-1675701502-2000.jpg", "I love my puppy! It is a Chihuahua", date));
        posts.add(new Post(3, 1,"https://assets.whichcar.com.au/image/upload/s--ZNDmUGiO--/ar_2.304921968787515,c_fill,f_auto,q_auto:good/v1/archive/whichcar/2020/02/19/-1/Ferrari-F40-Monaco-fire.jpg", "This is one Hot new Car!!", date));
        posts.add(new Post(4, 2, "https://i.dell.com/das/xa.ashx/global-site-design%20WEB/f23bf593-0fbf-5acd-3452-bf1828688b13/1/OriginalPng?id=Dell/Product_Images/Dell_Client_Products/Notebooks/Alienware_Notebooks/alienware_17_ranger/hero/laptop-alienware-17-campaign-hero-504x350-ng.psd", "This new gaming rig is top of line!", date));
        posts.add(new Post(5, 3, "https://i.ytimg.com/vi/1X2N79v-Hjw/hqdefault.jpg", "Taking the hobbits to Isengard", date));
        posts.add(new Post(6, 3, "https://www.looper.com/img/gallery/how-to-get-the-unlimited-ammo-scorpion-gun-in-halo-infinite/intro-1643229963.jpg", "Welcome to Halo", date));
        posts.add(new Post(7, 4, "https://c4.wallpaperflare.com/wallpaper/1005/311/793/anime-re-creators-meteora-osterreich-wallpaper-preview.jpg", "Best narrator to ever grace a show", date));


        pageable = PageRequest.of(0, 5);
    }

    @Autowired
    PostRepo postRepo;


    //Test to see if Repo returns same 5 items
    @Test
    void test_getFirstFivePosts_positive() {
        Page<Post> pageOfPosts = postRepo.findAll(pageable);

        List<Post> actual = pageOfPosts.getContent();


        Assertions.assertEquals(posts.subList(0, 5), actual);
    }

    //Test to see if pages are at least 5 large
    @Test
    void test_getSizeFirstFivePosts_positive() {
        Page<Post> pageOfPosts = postRepo.findAll(pageable);

        List<Post> actual = pageOfPosts.getContent();


        Assertions.assertEquals(posts.subList(0, 5).size(), actual.size());
    }
}
