import Header from "../components/header/header";
import Footer from "../components/footer/footer";
import UrlShortener from "../components/url_shortener.jsx/url_shortener";

const Homepage = () => {

    return(
        <>
            <div>
                <Header/>
            </div>
            <div>
                <UrlShortener/>
            </div>
            <div>
                <Footer/>
            </div>
        </> 
    )
}
export default Homepage;