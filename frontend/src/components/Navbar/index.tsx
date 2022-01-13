import { ReactComponent as GithubIcon } from 'assets/img/GitHub.svg';
import './styles.css'

function Navbar() {
    
    return (
        <header>
            <nav className='container'>
                <div className='dsmovie-nav-content'>
                    <h1>DsMovie</h1>
                    <a href="https://github.com/LuccasLpn">
                        <div className='dsmovie-contact-container'>
                            <GithubIcon />
                             <p className='dsmovie-contact-link'>/LuccasLpn</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );

}
export default Navbar;