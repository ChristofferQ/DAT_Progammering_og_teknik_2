import React, { useState, useEffect } from "react";
import facade from "../ApiFacade";

const Race = () => {
    const [raceList, setRaceList] = useState([]);
    useEffect(() => {
        facade.fetchData("race")
            .then(data => {
                setRaceList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
        <div className="container mt-5">
            <h2>List Of Races</h2>
            <table className="table mt-4">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Location</th>
                </tr>
                </thead>
                <tbody>
                {
                    raceList.map((race, index) => (
                        <tr>
                            <td>{race.id}</td>
                            <td>{race.name}</td>
                            <td>{race.date}</td>
                            <td>{race.time}</td>
                            <td>{race.location}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}

export default Race;