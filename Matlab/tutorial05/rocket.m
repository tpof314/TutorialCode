% Final velocity (m/s)
v = input('Please enter the final velocity: ');

% Acceleration (m/s^2)
a = -9.81;

% displacement (m)
s = (100 - 7.5) * 1000;

% initial velocity(m/s)
u = sqrt(v^2 - 2*a*s);

disp(u);