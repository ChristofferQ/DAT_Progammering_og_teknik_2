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
import Home from "./Components/Home";
import Race from "./Components/Race";
import RaceCar from "./Components/RaceCar";



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
                         <Route exact path="/">
                         <Home />
                         </Route>
                         <Route exact path="/race">
                            <Race />
                         </Route>
                        <Route exact path="/addrace">
                            <addrace />
                        </Route>
                        <Route exact path="/delete">
                            <delete />
                        </Route>
                        <Route exact path="/racecar">
                            <RaceCar />
                        </Route>
                        <Route path="/login">
                                <Login/>
                        </Route>
                        <NoMatch />
                    </Switch>
                </div>)}
        </div>
    )

}



export default App;
