m = input('Please enter a mark: ');
if m >= 85 && m <= 100
    disp('HD');
elseif m >= 70 && m < 85
    disp('D');
elseif m >= 60 && m < 70
    disp('C');
elseif m >= 50 && m < 60
    disp('P');
else
    disp('Fail');
end