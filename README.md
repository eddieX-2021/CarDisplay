Project Overview
This project appears to implement a state management system in Java, with classes handling different states of a process or task, alongside a GUI component for interaction. Below is a summary of the main components of the project:

Key Classes
1. State Class
   Purpose: Represents the state of a process.
   Attributes:
   state (int): Can hold values -1, 0, or 1, representing the following:
   -1: "等待中" (Waiting)
   0: "进行中" (In Progress)
   1: "已完成" (Completed)
   Methods:
   getState(): Returns the current state as an integer.
   toString(): Provides a string description of the current state in Chinese characters.
   changeState(): Advances the state of the process from -1 to 0 to 1, where 1 is a terminal state.
2. Other Classes (CarInfo.java, WaitingLine.java, TestGui.java)
   These additional files likely represent other essential parts of the system:
   CarInfo.java: Likely handles car-related data.
   WaitingLine.java: May manage a queue of items or processes waiting for execution.
   TestGui.java: Likely serves as the graphical user interface for interacting with the system, visualizing states, and possibly allowing users to change the state of processes.
   Features
   State Transitions: The state can move sequentially through -1, 0, and 1, with appropriate Chinese labels indicating the current phase of the process.
   Error Handling: If an invalid state is detected, it returns "错误" (Error).
   Change State Logic: It prevents the state from exceeding the terminal state (1).
   Instructions
   The project can be compiled and run using any standard Java environment.
   The State class manages the status of processes, while the GUI allows for user interaction.