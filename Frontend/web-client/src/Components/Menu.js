import {NavLink} from 'react-router-dom';
import React, {useEffect, useState} from "react";
import facade from "../ApiFacade";
import {forEach} from "react-bootstrap/ElementChildren";

function Menu () {

    const logout = () => { facade.logout() }

    return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link btn btn-primary text-white" to="/">Home</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="#"></NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link btn btn-primary text-white" to="/race">Races</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="#"></NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link btn btn-primary text-white" to="/addrace">Add Race</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="#"></NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link btn btn-primary text-white" to="/delete">Delete Car</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link" to="#"></NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink exact active className="active nav-link btn btn-primary text-white" to="/racecar">Race & Car</NavLink>
                    </li>
                </ul>
                <form className="d-flex">
                    <NavLink exact active className="active nav-link text-black" to="#">

                    </NavLink>
                    <button onClick={logout} className="btn btn-success btn-logout">Logout</button>
                </form>
            </div>
        </div>
    </nav>
    )
}


export default Menu;