import { useState } from "react"
const UrlShortener = () =>{
    const [originalUrl, setOriginalUrl] = useState("")
    const [shortcode, setShortcode] = useState("")
    const BASE_URL = "http://localhost:8080";



    const handleUrlShortening = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch ("http://localhost:8080/shortenUrl", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    originalUrl: originalUrl
                })

            }
        );

            const shortcode = await response.text();
            setShortcode(shortcode)
            console.log(shortcode)

        } catch (error) {
            console.log(error)
        }

    }

    return(
        <>
            <div>
                <div>
                    <p>Create professional links</p>
                    <p>At zero cost</p>
                </div>
                <h3>Use our free link shortener </h3>
                <form onSubmit={handleUrlShortening}>
                    <span>
                        <input 
                            type="text"  
                            required 
                            onChange={(event)=> setOriginalUrl(event.target.value)} 
                            value={originalUrl}
                        />
                        <button type="submit">Shorten for free</button>
                    </span>
                    <span>
                        {shortcode &&(
                                <p>{shortcode}</p>
                            )
                        }
                    </span>
                    <span>
                        {shortcode && (
                                <a 
                                    href={`${BASE_URL}/${shortcode}`} 
                                    target="_blank" 
                                >
                                    {`${BASE_URL}/${shortcode}`}
                                </a>
                            )
                        }
                    </span>
                </form>
                <div>
                    <span>Free</span>
                    <span>QR code</span>
                    <span>Copy and share</span>
                </div>
            </div>
        </>
    )
}
export default UrlShortener