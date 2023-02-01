package com.cognizant.Post.Integration;

import com.cognizant.Post.model.PageOfItems;
import com.cognizant.Post.model.Post;
import com.cognizant.Post.repository.PostRepo;
import com.cognizant.Post.services.PostServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PostServiceIntegrationTest {

    PageOfItems<Post> pageOfItems = new PageOfItems<>();
    List<Post> posts = new ArrayList<>();
    private LocalDate date = LocalDate.now();

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostServiceImp postServiceImp;

    @BeforeAll
    void init() {
        posts.add(new Post(1, 1, "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2021%2F07%2F13%2FUltimate-Veggie-Burgers-FT-Recipe-0821.jpg&q=60", "Food at McDonalds was great! Lorem ipsum dolor sit, amet consectetur adipisicing elit. Nam distinctio quaerat.", date));
        posts.add(new Post(2, 2, "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F47%2F2021%2F03%2F09%2Fchihuahua-laying-down-wooden-floor-1675701502-2000.jpg", "I love my puppy! It is a Chihuahua", date));
        posts.add(new Post(3, 1,"https://assets.whichcar.com.au/image/upload/s--ZNDmUGiO--/ar_2.304921968787515,c_fill,f_auto,q_auto:good/v1/archive/whichcar/2020/02/19/-1/Ferrari-F40-Monaco-fire.jpg", "This is one Hot new Car!!", date));
        posts.add(new Post(4, 2, "https://i.dell.com/das/xa.ashx/global-site-design%20WEB/f23bf593-0fbf-5acd-3452-bf1828688b13/1/OriginalPng?id=Dell/Product_Images/Dell_Client_Products/Notebooks/Alienware_Notebooks/alienware_17_ranger/hero/laptop-alienware-17-campaign-hero-504x350-ng.psd", "This new gaming rig is top of line!", date));
        posts.add(new Post(5, 3, "https://i.ytimg.com/vi/1X2N79v-Hjw/hqdefault.jpg", "Taking the hobbits to Isengard", date));
        posts.add(new Post(6, 3, "https://www.looper.com/img/gallery/how-to-get-the-unlimited-ammo-scorpion-gun-in-halo-infinite/intro-1643229963.jpg", "Welcome to Halo", date));
        posts.add(new Post(7, 4, "https://c4.wallpaperflare.com/wallpaper/1005/311/793/anime-re-creators-meteora-osterreich-wallpaper-preview.jpg", "Best narrator to ever grace a show", date));
        posts.add(new Post(8, 4, "https://clutchpoints.com/wp-content/uploads/2021/09/There_s-no-better-time-to-jump-into-Eorzea-here_s-all-you-need-to-know-to-start-playing-FFXIV.jpg", "Critically acclaimed MMORPG Free up to level 60 including the widely well-received Heavensward expansion!", date));
        posts.add(new Post(9, 5, "https://media-cldnry.s-nbcnews.com/image/upload/newscms/2019_03/2720206/ss-190117-twip-06.jpg", "20 ft Great White found near your favorite beach?", date));
        posts.add(new Post(10, 5, "https://cdn.mos.cms.futurecdn.net/GY9JBbrzsGsz2psUv6pgdV.jpg", "Leaving for mars!", date));
        posts.add(new Post(11, 2, "https://upload.wikimedia.org/wikipedia/commons/3/37/Killerwhales_jumping.jpg", "Mother Orca with calf!", date));
        posts.add(new Post(12, 3, "https://cdn.nba.com/manage/2022/06/curry-shooting-1920-220606.jpg", "NBA Finals continue today!", date));
        posts.add(new Post(13, 1, "https://static.onecms.io/wp-content/uploads/sites/28/2020/08/11/beluga-whale-saved-sancutary-iceland-BELUGA0820.jpg", "Lost Beluga whale named George found swimming in Hawaii thousands of miles away from his home.", date));
        posts.add(new Post(14, 2, "https://i.cbc.ca/1.6479816.1654573114!/fileImage/httpImage/image.JPG_gen/derivatives/16x9_780/hkn-avalanche-oilers-20220606.JPG", "Avalanche are heading to the Stanley Cup Finals", date));
        posts.add(new Post(15, 1, "https://news.mit.edu/sites/default/files/styles/news_article__image_gallery/public/images/202110/thalamus-900x600.jpg", "These are the parts of your brain you may or may not be using.", date));
        posts.add(new Post(16, 2, "https://www.oregonlive.com/resizer/wl59POuWuWaDa1RzFH4MlpJIb58=/1280x0/smart/cloudfront-us-east-1.images.arcpublishing.com/advancelocal/6EM3ARICCZC3FMACOBQE77M4WY.JPG", "Womens College World Series 2022!", date));
        posts.add(new Post(17, 3, "https://phantom-marca.unidadeditorial.es/5239496b557a1d63c4b1af89c0c56c40/resize/1320/f/jpg/assets/multimedia/imagenes/2022/04/01/16488348581803.jpg", "Who is ready?", date));
        posts.add(new Post(18, 3, "https://www.ctvnews.ca/polopoly_fs/1.5394699.1618932908!/httpImage/image.jpg_gen/derivatives/landscape_1020/image.jpg", "New Study! Sleeping less than an hour a night is bad for your health!", date));
        posts.add(new Post(19, 3, "https://news.mit.edu/sites/default/files/styles/news_article__image_gallery/public/images/201811/MIT-Cognitive-Flexibility_0.jpg", "This is your brain when you break the speed limit.", date));
        posts.add(new Post(20, 3, "https://pbs.twimg.com/media/Ek8Ih2qVcAAiOSL.jpg", "It gonna rain! But not that much.", date));
        posts.add(new Post(21, 4, "https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/F3020C5A6702EF51552E388CEF7EDFE46CC96A370C2E1C57F9533573DCEFA766/scale?width=1200&aspectRatio=1.78&format=jpeg", "New episode of Kenobi tonight!", date));
        posts.add(new Post(22, 5, "https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/E88C6A9ED0D45CCFC1B281CC0A9ECCB03D2FE038A86749C655C9264FCAE37345/scale?width=1200&aspectRatio=1.78&format=jpeg", "Coming out tomorrow. Cannot wait to see some new Marvel action!", date));
        Collections.reverse(posts);
    }

    @Test
    void test_getPosts() {
        pageOfItems.setItems(posts.subList(0, 5));
        pageOfItems.setHasNext(true);
        pageOfItems.setTotalElements(22);

        PageOfItems<Post> actualPosts = postServiceImp.getPosts(0, 5);

        Assertions.assertEquals(pageOfItems, actualPosts);
    }

    @Test
    void test_getPosts_secondPage() {
        pageOfItems.setItems(posts.subList(5, 10));
        pageOfItems.setHasNext(true);
        pageOfItems.setTotalElements(22);

        PageOfItems<Post> actualPosts = postServiceImp.getPosts(1, 5);

        Assertions.assertEquals(pageOfItems.getItems(), actualPosts.getItems());

    }
}
