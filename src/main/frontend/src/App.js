import React, {useEffect, useState} from 'react';
import { BrowserRouter, Routes, Route }  from "react-router-dom";
import axios from 'axios';
import GatheringList from "./GatheringList";
import GatheringDetail from "./GatheringDetail";
import GatheringAdd from "./GatheringAdd";
import GatheringUpdate from "./GatheringUpdate";

function App() {

  return (
      <BrowserRouter>
          <Routes>
              <Route path="/" element={<GatheringList />}></Route>
              <Route path="/:gatheringId" element={<GatheringDetail />}></Route>
              <Route path="/add" element={<GatheringAdd />}></Route>
              <Route path="/update/:gatheringId" element={<GatheringUpdate />}></Route>
          </Routes>
      </BrowserRouter>

  );
}

export default App;