import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useParams,
    useRouteMatch,
    NavLink
} from "react-router-dom";

import Login from "./Components/Login";
import Menu from "./Components/Menu";
import NoMatch from "./Components/NoMatch";

import React, { useState,useEffect } from "react";
import facade from "./ApiFacade";



function App() {
    const [loggedIn, setLoggedIn] = useState(false)
    const [userName, setUserName] = useState("")


    const logout = () => {
        // confused on how we get this to work as it's not being called
        facade.logout()
        setLoggedIn(false)
    }

    if (logout == true) {
        return "admin has logged out"
    }

    const login = (user, pass) => {
        setUserName(user);
        facade.login(user,pass)
            .then(res =>setLoggedIn(true));
    }

    if (login === true) {
        return "admin has logged in"
    }

    return (
        <div>
            {!loggedIn ? (<Login login={login} />) :
                (<div>
                    <Menu />
                    <Switch>
                         <Route exact path="/menu-one">
                         <MenuOne />
                         </Route>
                         <Route exact path="/menu-two">
                            <MenuTwo />
                         </Route>
                        <Route path="/login">
                                <Login/>
                        </Route>
                        <Route exact path="/menu-three">
                             <MenuThree />
                        </Route>
                        <NoMatch />
                    </Switch>
                </div>)}
        </div>
    )

}



export default App;
